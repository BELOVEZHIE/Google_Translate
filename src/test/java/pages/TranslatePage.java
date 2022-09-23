package pages;

import model.BaseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.TestUtils.jsClick;

public class TranslatePage extends BaseModel {

    public TranslatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div[@class = 'VfPpkd-Bz112c-RLmnJb'])[1]")
    private WebElement leftDropDown;

    @FindBy(xpath = "(//div[@data-language-code = 'de'])[1]")
    private WebElement germanLanguageSelector;

    @FindBy(xpath = "(//div[@class = 'VfPpkd-Bz112c-RLmnJb'])[3]")
    private WebElement rightDropDown;

    @FindBy(xpath = "(//div[@data-language-code = 'es'])[2]")
    private WebElement spanishLanguageSelection;

    @FindBy(xpath = "//textarea[@class = 'er8xn']")
    private WebElement leftInputField;

    @FindBy(xpath = "//span[@jsname = 'jqKxS']")
    private WebElement translatedWord;

    @FindBy(xpath = "(//div[@class = 'VfPpkd-Bz112c-RLmnJb'])[2]")
    private WebElement swapLanguagesButton;

    @FindBy(xpath = "(//i[text() = 'clear'])[3]")
    private WebElement leftClearButton;

    @FindBy(xpath = "//a[@class = 'ita-kd-icon-button ita-kd-dropdown ita-kd-right']")
    private WebElement inputToolDropDown;

    @FindBy(xpath = "//span[@class = 'ita-kd-menuitem-inputtool-icon ita-kd-menuitem-span ita-kd-img ita-icon-0']")
    private WebElement keyboardIcon;

    @FindBy(xpath = "(//nav[@class = 'U0xwnf']/div)[1]")
    private WebElement textButton;

    @FindBy(xpath = "(//button[@id = 'K16'])[1]")
    private WebElement uppercaseKeyboardButton;

    @FindBy(id = "K72")
    private WebElement uppercaseHButton;

    @FindBy(id = "K73")
    private WebElement lowercaseIButton;

    @FindBy(id = "K49")
    private WebElement exlamPointButton;

    public TranslatePage getTranslatedWords(String strGerman)  {
        leftDropDown.click();
        jsClick(getDriver(), germanLanguageSelector);
        rightDropDown.click();
        jsClick(getDriver(), spanishLanguageSelection);
        jsClick(getDriver(), rightDropDown);
        leftInputField.sendKeys(strGerman);

        return this;
    }

    public TranslatePage swapLanguages(String strSpanish) {
        getWait().until(ExpectedConditions.textToBe(By.xpath("//span[@jsname = 'jqKxS']"), strSpanish));
        swapLanguagesButton.click();

        return this;
    }

    public TranslatePage getKeyboardSign() {
        jsClick(getDriver(), leftClearButton);
        inputToolDropDown.click();
        keyboardIcon.click();
        textButton.click();
        uppercaseKeyboardButton.click();
        uppercaseHButton.click();
        lowercaseIButton.click();
        uppercaseKeyboardButton.click();
        exlamPointButton.click();

        return this;
    }

    public String getText(String str) {
        getWait().until(ExpectedConditions.textToBe(By.xpath("//span[@jsname = 'jqKxS']"), str));

        return translatedWord.getText();
    }
}