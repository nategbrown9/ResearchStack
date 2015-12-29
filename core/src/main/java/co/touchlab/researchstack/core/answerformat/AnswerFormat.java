package co.touchlab.researchstack.core.answerformat;

import java.io.Serializable;

import co.touchlab.researchstack.core.dev.DevUtils;
import co.touchlab.researchstack.core.ui.scene.DateQuestionBody;
import co.touchlab.researchstack.core.ui.scene.FormBody;
import co.touchlab.researchstack.core.ui.scene.IntegerQuestionBody;
import co.touchlab.researchstack.core.ui.scene.MultiChoiceQuestionBody;
import co.touchlab.researchstack.core.ui.scene.NotImplementedStepBody;
import co.touchlab.researchstack.core.ui.scene.SingleChoiceQuestionBody;
import co.touchlab.researchstack.core.ui.scene.TextQuestionBody;


public abstract class AnswerFormat implements Serializable
{
    public enum QuestionType
    {
        None,
        Form,
        Scale,
        SingleChoice,
        MultipleChoice,
        Decimal,
        Integer,
        Boolean,
        Text,
        TimeOfDay,
        DateAndTime,
        Date,
        TimeInterval;

        public Class<?> getSceneClass()
        {
            switch (this)
            {
                case SingleChoice:
                    //TODO type <Integer>
                    return SingleChoiceQuestionBody.class;
                case MultipleChoice:
                    //TODO type <Integer>
                    return MultiChoiceQuestionBody.class;
                case Text:
                    return TextQuestionBody.class;
                case Integer:
                    return IntegerQuestionBody.class;
                case Date:
                    return DateQuestionBody.class;
                case Form:
                    return FormBody.class;
                case Scale:
                case Decimal:
                case Boolean:
                case TimeOfDay:
                case DateAndTime:
                case TimeInterval:
                default:
                    return NotImplementedStepBody.class;
            }
        }

    }

    public enum ChoiceAnswerStyle
    {
        SingleChoice,
        MultipleChoice
    }

    public enum NumberFormattingStyle
    {
        Default,
        Percent
    }

    public enum DateAnswerStyle
    {
        DateAndTime,
        Date
    }

    public AnswerFormat()
    {
    }

    public QuestionType getQuestionType()
    {
        return QuestionType.None;
    }

    //TODO figure out if this makes sense
    public Class getQuestionResultClass()
    {
        DevUtils.throwUnsupportedOpException();
        return null;
    }
}
