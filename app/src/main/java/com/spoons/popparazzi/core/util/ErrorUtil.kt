package com.spoons.popparazzi.core.util

object ErrorUtil {
    fun bindingException(): Throwable = IllegalStateException("VIEW_BINDING_LIFECYCLE_ERROR")
    fun onboardingException(pos: Int): Throwable = IllegalStateException("Invalid onboarding position: $pos")
}