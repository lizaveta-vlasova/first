package com.mobileapplication.dao;


import com.mobileapplication.domain.Option;

import java.util.List;
import java.util.Set;

public interface OptionDao {
    List<Option> findAll();
    Option findOptionById(Integer id);
    void removeOption(Option option);
    void save(Option option);
}
