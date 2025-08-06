package com.example.exercise.Reposytory;

import com.example.exercise.Model.CurrencyRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyRequest,Integer>
{

}
