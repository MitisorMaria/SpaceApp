package com.example.demo.repositories;

import com.example.demo.bll.Captain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaptainRepository  extends JpaRepository<Captain, Long> {
}
