package hbcu.stay.ready.phone;

import hbcu.stay.ready.exceptions.InvalidPhoneNumberFormatException;
import hbcu.stay.ready.tools.RandomNumberFactory;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.logging.Logger;


public final class PhoneNumberFactory extends RandomNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {


        PhoneNumber[] PhoneNumberArray = new PhoneNumber[phoneNumberCount];

        for (int i = 0; i < PhoneNumberArray.length; i++) {
            PhoneNumberArray[i] = createRandomPhoneNumber();

        }
        return PhoneNumberArray;
    }


    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {

        int areaCode = createInteger(100,999);
        int centralOfficeCode = createInteger(100,999);
        int phoneLineCode = createInteger(1000,9999);

        return createPhoneNumberSafely(areaCode,centralOfficeCode,phoneLineCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        try {
           logger.info("This is not a number " + "(" + areaCode + ")-" + centralOfficeCode + "-" + phoneLineCode);
            return createPhoneNumber("(" + areaCode + ")-" + centralOfficeCode + "-" + phoneLineCode);

        } catch (InvalidPhoneNumberFormatException e) {

            return null;
        }
    }
        /**
         * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
         * @return a new phone number object
         * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
         */ // TODO - Add throws statement to method signature
        public static PhoneNumber createPhoneNumber (String phoneNumberString) throws InvalidPhoneNumberFormatException {
        {
            logger.info("Attempting to create a new PhonrNumber object with a value of" + phoneNumberString);

            PhoneNumber phoneNumber = new PhoneNumber(phoneNumberString);

            return phoneNumber;
        }
    }
}
