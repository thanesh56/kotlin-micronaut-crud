package com.thanesh.controller

import com.thanesh.domain.Profile
import com.thanesh.service.ProfileService
import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller("/api")
class ProfileController {

    @Inject
    lateinit var profileService: ProfileService

    @Post("/profile")
    fun save(@Body profile: Profile): Profile {
        log.info("Save Profile : {}", profile)
        return profileService.insert(profile)
    }

    @Get("/profile/{id}")
    fun getProfile(id: Long): Profile {
        log.info("Get Profile by Id : {}", id)
        return profileService.getProfile(id)
    }

    @Get("/profile")
    fun getAllProfile(): Iterable<Profile> {
        log.info("Get All profile")
        return profileService.getAllProfile()
    }

    @Put("/profile")
    fun updateProfile(profile: Profile): Profile {
        log.info("Update Profile ; {}", profile)
        return profileService.update(profile)
    }

    @Delete("/profile/{id}")
    fun deleteProfile(id: Long): Boolean {
        log.info("Delete profile by Id : {}", id)
        return profileService.deleteProfile(id)
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(ProfileController::class.java)
    }

}