package com.example.exercise.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "nbp_requests")
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRequest
{
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "currency")
    private String currency;

    @Column(name = "name")
    private String name;

    @Column(name = "request_date",updatable = false,insertable = false)
    private LocalDateTime date;

    @Column(name = "value")
    private Float value;

    //Constructor used do save data to database
    public CurrencyRequest(String currency, String name, Float value)
    {
        this.currency = currency;
        this.name = name;
        this.value = value;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
