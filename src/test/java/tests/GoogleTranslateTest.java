package tests;

import model.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TranslatePage;
import utils.ExcelUtils;

public class GoogleTranslateTest extends BaseTest {
    private static final String TEST_DATA_1 = "Demokratien";
    private static final String TEST_DATA_2 = "Democracia";
    private static final String EXPECTED_TRANSLATE_1 = "Demokratie";
    private static final String EXPECTED_TRANSLATE_2 = "Hi!";

    @DataProvider
    public Object[][] testData1() {
        Object[][] testObjArray = ExcelUtils.getTableArray("src//main//resources//testdata.xlsx", "Sheet1");
        return (testObjArray);
    }

    @Test(dataProvider = "testData1")
    public void testWordTranslation(String testData, String expectedResult) throws InterruptedException {
        String actualResult1 = new TranslatePage(getDriver())
                .getTranslatedWords(testData)
                .getText(expectedResult);

        Assert.assertEquals(actualResult1, expectedResult);
    }

    @Test
    public void testSwapLanguage() {
        String actualResult2 = new TranslatePage(getDriver())
                .getTranslatedWords(TEST_DATA_1)
                .swapLanguages(TEST_DATA_2)
                .getText(EXPECTED_TRANSLATE_1);

        Assert.assertEquals(actualResult2, EXPECTED_TRANSLATE_1);
    }

    @Test
    public void testKeyboardIntercaction() {
        String res = new TranslatePage(getDriver())
                .getTranslatedWords(TEST_DATA_1)
                .swapLanguages(TEST_DATA_2)
                .getKeyboardSign()
                .getText(EXPECTED_TRANSLATE_2);

        Assert.assertEquals(res, EXPECTED_TRANSLATE_2);
    }
}