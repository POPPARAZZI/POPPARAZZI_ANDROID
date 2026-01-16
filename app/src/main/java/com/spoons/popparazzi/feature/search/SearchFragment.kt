package com.spoons.popparazzi.feature.search

import android.graphics.PointF
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.util.FusedLocationSource
import com.spoons.popparazzi.R
import com.spoons.popparazzi.core.ui.base.fragment.BaseViewBindingFragment
import com.spoons.popparazzi.core.util.PermissionUtil
import com.spoons.popparazzi.databinding.FragmentSearchBinding

class SearchFragment: BaseViewBindingFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate), OnMapReadyCallback {
    private val locationSource: FusedLocationSource by lazy { FusedLocationSource(this, PermissionUtil.LOCATION_PERMISSION_REQUEST_CODE) }
    private lateinit var naverMap: NaverMap

    override fun regListener() {
        super.regListener()

        binding.clSearch.setOnClickListener {
            if(binding.motion.currentState == R.id.motion_hide) binding.motion.setTransition(R.id.t_detail_hide)
            binding.motion.transitionToState(R.id.motion_detail)
//            naverMap.setContentPadding(0, 0, 0, 500)
//            naverMap.uiSettings.setLogoMargin(16, 16, 16, 16)
//            naverMap.test(500f)
        }

        binding.clCategory.setOnClickListener {
            binding.motion.transitionToEnd()
//            naverMap.setContentPadding(0, 0, 0, 0)
//            naverMap.uiSettings.setLogoMargin(16, 16, 16, 16)
//            naverMap.test(-500f)
        }

        binding.motion.setTransitionListener(object: MotionLayout.TransitionListener {
            override fun onTransitionStarted(motionLayout: MotionLayout?, startId: Int, endId: Int) = Unit
            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int, ) = Unit
            override fun onTransitionTrigger(motionLayout: MotionLayout?, triggerId: Int, positive: Boolean, progress: Float) = Unit
            override fun onTransitionChange(motionLayout: MotionLayout?, startId: Int, endId: Int, progress: Float) {
//                naverMap.setContentPadding(0, 0, 0, binding.viewPopup.height / 10)
//                naverMap.uiSettings.setLogoMargin(16, 16, 16, 16 + (binding.viewPopup.height / 10));
            }
        })


    }

    private fun NaverMap.test(px: Float) {
        val projection = projection
        val center = cameraPosition.target

        // 현재 중심이 화면의 어느 픽셀인지
        val centerPoint = projection.toScreenLocation(center)
        // 위로 dyPx 만큼 이동 (Y는 아래로 증가하니까 -)
        val newPoint = PointF(centerPoint.x, centerPoint.y + px)

        // 다시 지도 좌표로 변환
        val newLatLng = projection.fromScreenLocation(newPoint)

        moveCamera(CameraUpdate.scrollTo(newLatLng))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val map = childFragmentManager.findFragmentById(R.id.map_search) as MapFragment?
            ?: MapFragment.newInstance().also {
                childFragmentManager.beginTransaction().add(R.id.map_search, it).commit()
            }
        map.getMapAsync(this)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String?>,
        grantResults: IntArray,
    ) {
        if(locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults)) {
            if(!locationSource.isActivated) {
                naverMap.locationTrackingMode = LocationTrackingMode.None
            }
            return
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onMapReady(map: NaverMap) {
        this.naverMap = map
        map.uiSettings.logoGravity = Gravity.TOP or Gravity.END
//        map.locationSource = locationSource
    }
}