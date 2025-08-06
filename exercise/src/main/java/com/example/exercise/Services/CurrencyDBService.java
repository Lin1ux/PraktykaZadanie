package com.example.exercise.Services;

import com.example.exercise.Model.CurrencyRequest;
import com.example.exercise.Reposytory.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyDBService
{
    @Autowired
    private CurrencyRepository currencyRepository;

    //Save Request to Data base
    public CurrencyRequest saveCurrencyRequest(CurrencyRequest currencyRequest)
    {
        return currencyRepository.save(currencyRequest);
    }

    //Get all data associated with nickname from database
    public List<CurrencyRequest> getRequestsByNickname(String nickname)
    {
        List<CurrencyRequest> RequestList = new ArrayList<CurrencyRequest>();
        //Remove Requests with diffrent cases
        for(CurrencyRequest req : currencyRepository.findByNickname(nickname))
        {
            if(req.getNickname().equals(nickname))
            {
                RequestList.add(req);
            }
        }
        return RequestList;
    }

    //get all data from database
    public List<CurrencyRequest> getAllRequests()
    {
        return currencyRepository.findAll();
    }
}
