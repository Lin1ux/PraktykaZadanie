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

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "request_date",updatable = false,insertable = false)
    private LocalDateTime date;

    @Column(name = "value")
    private Float value;

    public CurrencyRequest(String currency, String nickname, LocalDateTime  date, Float value)
    {
        this.id = 0;
        this.currency = currency;
        this.nickname = nickname;
        this.date = date;
        this.value = value;
    }

    public CurrencyRequest(String currency, String nickname, Float value)
    {
        this.currency = currency;
        this.nickname = nickname;
        this.value = value;
    }

    /*public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public Float getValue() { return value; }
    public void setValue(Float value) { this.value = value; }*/
}
