package com.example.exercise.Reposytory;

import com.example.exercise.Model.CurrencyRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<CurrencyRequest,Integer>
{
    List<CurrencyRequest> findByNickname(String nickname);
}
