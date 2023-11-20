package com.example.cakedog;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecimalDigitsInputFilter implements InputFilter {
    Pattern mPattern;

    public DecimalDigitsInputFilter(int digitsFirstDot, int digitsMiddleDot, int digitsLastDot, int digitsAfterHyphen) {
        mPattern = Pattern.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})");
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

        Matcher matcher = mPattern.matcher(dest);
        if(!matcher.matches()) {
            return "";
        }

        return null;
    }
}
