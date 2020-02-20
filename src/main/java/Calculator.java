import java.math.BigDecimal;

public class Calculator {
    private BigDecimal accumulator;
    private BigDecimal op1;
    private BigDecimal op2;

    public Calculator() {
        this.accumulator = BigDecimal.ZERO;
        this.op1 = BigDecimal.ZERO;
        this.op2  = BigDecimal.ZERO;
    }

    public BigDecimal getAccumulator(){
        return accumulator;
    }

    public void setAccumulator(BigDecimal value){
        this.accumulator = value;
    }

    public void setOperands(BigDecimal val1, BigDecimal val2){
        op1 = val1;
        op2 = val2;
    }

    public void add(){
        accumulator = op1.add(op2);
    }

    public void subtract(){
        accumulator = op1.subtract(op2);
    }

    public void multiply(){
        accumulator = op1.multiply(op2);
    }

    public void divide(){
        accumulator = op1.divide(op2);
    }
}
