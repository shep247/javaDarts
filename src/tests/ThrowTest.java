package tests;

import junit.framework.TestCase;

import main.Throw;

public class ThrowTest extends TestCase {

    private void trueValidation(String input){
        assertTrue(Throw.validateThrowInput(input));
    }

    private void falseValidation(String input){
        assertFalse(Throw.validateThrowInput(input));
    }

    public void testValidateThrowInputStartsWithLowerS() throws Exception {
        trueValidation("s1");
    }

    public void testValidateThrowInputStartsWithUpperS() throws Exception {
        trueValidation("S12");
    }

    public void testValidateThrowInputStartsWithLowerD() throws Exception {
        trueValidation("d2");
    }

    public void testValidateThrowInputStartsWithUpperD() throws Exception {
        trueValidation("D12");
    }

    public void testValidateThrowInputStartsWithLowerT() throws Exception {
        trueValidation("t12");
    }

    public void testValidateThrowInputStartsWithUpperT() throws Exception {
        trueValidation("T12");
    }

    public void testValidateThrowInputLowerM() throws Exception{
        trueValidation("m");
    }

    public void testValidateThrowInputUpperM() throws Exception{
        trueValidation("M");
    }

    public void testValidateThrowInputLowerB() throws Exception{
        trueValidation("b");
    }

    public void testValidateThrowInputUpperB() throws Exception{
        trueValidation("B");
    }

    public void testValidateNoLetter() throws Exception{
        trueValidation("13");
    }

    public void testValidateInvalidNoNumber() throws Exception{
        falseValidation("t");
    }

    public void testValidateInvalidLetter() throws Exception{
        falseValidation("e12");
    }

    public void testValidateTooManyLetters() throws Exception{
        falseValidation("ss12");
    }

    public void testValidateTooLowNumber() throws Exception{
        falseValidation("0");
    }

    public void testValidateBetween20And25Number() throws Exception{
        falseValidation("21");
        falseValidation("24");
        falseValidation("d24");
    }

    public void testValidate25Okay() throws Exception{
        trueValidation("25");
        trueValidation("d25");
    }

    public void testValidateAbove25False() throws Exception{
        falseValidation("26");
        falseValidation("t26");
    }

    private void assertThrowPoints(String throwStr, int expectedPoints){
        Throw t = new Throw(throwStr);
        assertEquals(expectedPoints, t.getThrowPoints());
    }
    public void testGetThrowPointsMissUpper() throws Exception{
        assertThrowPoints("M", 50);
    }

    public void testGetThrowPointsMissLower() throws Exception{
        assertThrowPoints("m", 50);
    }

    public void testGetThrowPointsSingleNoLetter() throws Exception{
        assertThrowPoints("1", 1);
    }

    public void testGetThrowPointsSingleLowerLetter() throws Exception{
        assertThrowPoints("s2", 2);
    }

    public void testGetThrowPointsSingleUpperLetter() throws Exception{
        assertThrowPoints("S3", 3);
    }

    public void testGetThrowPointsDoubleLowerLetter() throws Exception{
        assertThrowPoints("d4", 8);
    }

    public void testGetThrowPointsDoubleUpperLetter() throws Exception{
        assertThrowPoints("D5", 10);
    }

    public void testGetThrowPointsTripleLowerLetter() throws Exception{
        assertThrowPoints("t6", 18);
    }

    public void testGetThrowPointsTripleUpperLetter() throws Exception{
        assertThrowPoints("t7", 21);
    }

    public void testGetThrowPointsLowerBullseye() throws Exception{
        assertThrowPoints("b", 25);
    }

    public void testGetThrowPointsUpperBullseye() throws Exception{
        assertThrowPoints("B", 25);
    }
}