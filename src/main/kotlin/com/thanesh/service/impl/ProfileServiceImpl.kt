package com.thanesh.service.impl

import com.thanesh.domain.Profile
import com.thanesh.repository.ProfileRepository
import com.thanesh.service.ProfileService
import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.transaction.Transactional

@Singleton
@Transactional
open class ProfileServiceImpl : ProfileService {
    @Inject
    open lateinit var profileRepository: ProfileRepository

    override fun insert(profile: Profile): Profile {
        log.info("Saving Profile :$profile")
        profileRepository.save(profile)
        return profile
    }

    override fun getProfile(id: Long): Profile {
        log.info("Getting Profile by Id : $id")
        return profileRepository.findById(id).orElse(null)
    }

    override fun deleteProfile(id: Long): Boolean {
        try {
            profileRepository.deleteById(id)
            log.info("Deleting profile by id : $id")
            return true
        } catch (e: Exception) {
            log.info("Failed to delete Profile by id : $id")
            e.printStackTrace()
            return false
        }
    }

    override fun getAllProfile(): Iterable<Profile> {
        log.info("Find All")
        return profileRepository.findAll()
    }


    override fun update(profile: Profile): Profile {
        log.info("Update profile : $profile")
        return profileRepository.update(profile)
    }

    companion object {
        var log: Logger = LoggerFactory.getLogger(ProfileServiceImpl::class.java)
    }
}