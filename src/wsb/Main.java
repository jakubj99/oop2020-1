package wsb;

import wsb.genericTypes.Container;
import wsb.genericTypes.ContainerWithMemory;

public class Main {
    public static void main(String[] args) {

        Container<String> container = new ContainerWithMemory<>();
        container.add("#1");
        container.add("#2");
        container.add("#3");
        container.add("#4");
        container.add("#5");
        container.add("#6");
        System.out.println(container);
        container.remove("#1");
        System.out.println(container.getChanges());
        System.out.println(container);
        container.add("#1");
        container.remove("#6");
        System.out.println(container.getChanges());
        System.out.println(container);
        ((ContainerWithMemory<String>) container).prnt();
        System.out.println(container);
        ((ContainerWithMemory<String>) container).reverseToOldVer(3);

    }
}


