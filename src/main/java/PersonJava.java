import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PersonJava {

    private final String name;

    public PersonJava(String name) {
        this.name = name;
    }


    @NotNull
    public String getName() {
        return name;
    }
}
