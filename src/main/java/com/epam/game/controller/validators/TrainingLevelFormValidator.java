package com.epam.game.controller.validators;

import com.epam.game.constants.LevelGenerators;
import com.epam.game.constants.Settings;
import com.epam.game.controller.forms.CreateTrainingLevelForm;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class TrainingLevelFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> arg0) {
        return CreateTrainingLevelForm.class.equals(arg0);
    }

    @Override
    public void validate(Object formObject, Errors errors) {
        CreateTrainingLevelForm form = (CreateTrainingLevelForm) formObject;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "botsCount", "errors.trainingLevel.botsCount.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "errors.trainingLevel.type.empty");
        if(form.getBotsCount() < 1){
            errors.reject("botsCount", "errors.trainingLevel.botsCount.lesser-than-one");
        } else if(form.getBotsCount() > Settings.TRAINIG_BOT_LOGINS.length || form.getBotsCount() > Settings.MAXIMAL_PLAYERS_NUMBER - 1){
//            Object[] args = { Settings.TRAINIG_BOT_LOGINS.length };
            errors.reject("botsCount", "errors.trainingLevel.botsCount.greater-than-max");
        }
        if(LevelGenerators.getGenerator(form.getType()) == null) {
            errors.rejectValue("type", "errors.trainingLevel.type.incorrect");
        }
    }

}
