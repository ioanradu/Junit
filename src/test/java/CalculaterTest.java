import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CalculaterTest {
    private Calculator calculator;

    @Before
    public void createCalculator(){
        calculator = new Calculator();
    }

    @Test
    public void testNewCalculatorHasAnAccumulatorOfZero(){
        assertEquals(BigDecimal.ZERO, calculator.getAccumulator());
    }
    @Test
    public void testSettingAcumulatorValue(){
        BigDecimal value = new BigDecimal(5);
        calculator.setAccumulator(value);
        assertEquals(value, calculator.getAccumulator());
    }
}
