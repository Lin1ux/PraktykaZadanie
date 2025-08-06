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

    //Constructor used do save data to database
    public CurrencyRequest(String currency, String nickname, Float value)
    {
        this.currency = currency;
        this.nickname = nickname;
        this.value = value;
    }

    public String getNickname()
    {
        return this.nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }
}
