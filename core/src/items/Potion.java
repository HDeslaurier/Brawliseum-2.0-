package items;

/**
 * Created by rjawa on 6/10/2017.
 */

public class Potion
{
    private String potionName;
    private float value;

    public Potion(String potionName, float value)
    {
        this.potionName = potionName;
        this.value = value;
    }

    /**
     * @return the potionName
     */
    public String getPotionName() {
        return potionName;
    }

    /**
     * @param potionName the potionName to set
     */
    public void setPotionName(String potionName) {
        this.potionName = potionName;
    }

    /**
     * @return the value
     */
    public float getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(float value) {
        this.value = value;
    }

}
