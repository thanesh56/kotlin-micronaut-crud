package com.thanesh.service

import com.thanesh.domain.Profile

interface ProfileService {
    fun insert(profile: Profile): Profile
    fun update(profile: Profile): Profile
    fun getProfile(id: Long): Profile
    fun getAllProfile(): Iterable<Profile>
    fun deleteProfile(id: Long): Boolean
}