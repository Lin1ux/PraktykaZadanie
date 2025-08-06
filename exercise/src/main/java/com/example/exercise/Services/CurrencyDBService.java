package com.example.exercise.Services;

import com.example.exercise.Model.CurrencyRequest;
import com.example.exercise.Repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyDBService
{
    @Autowired
    private CurrencyRepository currencyRepository;

    //Save Request to Data base
    public CurrencyRequest saveCurrencyRequest(CurrencyRequest currencyRequest) throws ResponseStatusException
    {
        try
        {
            return currencyRepository.save(currencyRequest);
        }
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,
                    "Service Unavailable");
        }
    }

    //Get all data from database
    public List<CurrencyRequest> getAllRequests()
    {
        try
        {
            return currencyRepository.findAll();
        }
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,
                    "Service Unavailable");
        }
    }

    //Get all data associated with nickname from database
    public List<CurrencyRequest> getRequestsByNickname(String name)
    {
        List<CurrencyRequest> RequestList = new ArrayList<CurrencyRequest>();
        //Remove Requests with diffrent cases
        try
        {
            for(CurrencyRequest req : currencyRepository.findByName(name))
            {
                if(req.getName().equals(name))
                {
                    RequestList.add(req);
                }
            }
        }
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,
                    "Service Unavailable");
        }
        return RequestList;
    }

}
