package com.demo.fia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Long> {
    T findByPublicId(UUID publicId);
    List<T> findByPublicIdIn(List<UUID> publicIds);
    T deleteByPublicId(UUID publicId);
}