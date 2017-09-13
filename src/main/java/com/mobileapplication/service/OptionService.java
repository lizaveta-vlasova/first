package com.mobileapplication.service;

import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.Option;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


/**
 *
 */
public interface OptionService {
    /**
     * @return
     */
    List<Option> optionList();
    Option findOptionById(Integer optionId);
    void removeOption(Option option);
    void saveOption(Option option);
    void removeUncompotibleOption( Integer optionId,Integer currentOptionId);
    void addUncompatibleOption(Integer editOptionId, Integer optionId);
}
