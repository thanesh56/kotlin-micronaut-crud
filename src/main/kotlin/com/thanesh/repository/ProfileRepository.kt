package com.thanesh.repository

import com.thanesh.domain.Profile
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface ProfileRepository : CrudRepository<Profile, Long> {
}
