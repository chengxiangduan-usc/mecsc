////////////////////////////////////////////////////////////////////////////////
// The following FIT Protocol software provided may be used with FIT protocol
// devices only and remains the copyrighted property of Garmin Canada Inc.
// The software is being provided on an "as-is" basis and as an accommodation,
// and therefore all warranties, representations, or guarantees of any kind
// (whether express, implied or statutory) including, without limitation,
// warranties of merchantability, non-infringement, or fitness for a particular
// purpose, are specifically disclaimed.
//
// Copyright 2020 Garmin Canada Inc.
////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 21.40Release
// Tag = production/akw/21.40.00-0-g813c158
////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit;

interface Validator {
    /**
     * Validate if a Message is compatible with the version
     * @param mesg Message to validate
     * @return true if message is compatible false otherwise
     */
    boolean validateMesg(Mesg mesg);

    /**
     * Validate if a Message Definition is compatible with the version
     * @param defn Definition
     * @return true if Definition is compatible false otherwise
     */
    boolean validateMesgDefn(MesgDefinition defn);
}

class ProtocolValidator implements Validator {
    private Validator validator;

    ProtocolValidator(Fit.ProtocolVersion ver) {
        switch(ver) {
        case V1_0:
            validator = new V1Validator();
            break;

        default:
            validator = null;
            break;
        }
    }

    @Override
    public boolean validateMesg(Mesg mesg) {
        if(validator == null) {
            return true;
        }

        return validator.validateMesg(mesg);
    }

    @Override
    public boolean validateMesgDefn(MesgDefinition defn) {
        if(validator == null) {
            return true;
        }

        return validator.validateMesgDefn(defn);
    }
}

class V1Validator implements Validator {

    @Override
    public boolean validateMesgDefn(MesgDefinition defn) {
        for (DeveloperFieldDefinition ignored : defn.getDeveloperFields()) {
            return false;
        }

        for (FieldDefinition def : defn.getFields()) {
            int typeNum = def.getType() & Fit.BASE_TYPE_NUM_MASK;
            if (typeNum > Fit.BASE_TYPE_BYTE) {
                // Byte was the last type added to 1.0
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean validateMesg(Mesg mesg) {
        for (DeveloperField ignored : mesg.getDeveloperFields()) {
            return false;
        }

        for (Field fld : mesg.getFields()) {
            int typeNum = fld.getType() & Fit.BASE_TYPE_NUM_MASK;
            if (typeNum > Fit.BASE_TYPE_BYTE) {
                // Byte was the last type added to 1.0
                return false;
            }
        }

        return true;
    }
}
