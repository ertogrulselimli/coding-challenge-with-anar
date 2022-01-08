import java.util.Stack;

/**
 * @author Ertogrul Selimli on 1/8/2022
 * @project IntelliJ IDEA
 */
public class AnarSolution {

    public String testBrackets(String br) {
        char a1 = '(';
        char a2 = ')';
        char b1 = '[';
        char b2 = ']';
        char c1 = '{';
        char c2 = '}';
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < br.length(); i++) {
            char curr = br.charAt(i);
            if (curr == a1 || curr == b1 || curr == c1) {
                characterStack.push(br.charAt(i));
            } else {
                if (characterStack.size() > 0) {
                    Character p = characterStack.pop();
                    if ((p == a1) && curr != a2) {

                        return "invalid";
                    }
                    if ((p == b1) && curr != b2) {

                        return "invalid";
                    }
                    if ((p == c1) && curr != c2) {

                        return "invalid";
                    }
                } else {

                    return "invalid";
                }

            }
        }
        if (characterStack.size() > 0) {
            return "invalid";
        } else {
            return "valid";
        }
    }


    private void testBracketsWithMath (String br) {
        char a1 = '(';
        char a2 = ')';
        char b1 = '[';
        char b2 = ']';
        char c1 = '{';
        char c2 = '}';
        int x = 0, y = 0, z = 0;
        for (int i = 0; i < br.length(); i++) {
            char curr = br.charAt(i);
            if (curr == a1) {
                x = x - 1;
                if (y < 0) {
                    y = y - 1;
                }
                if (z < 0) {
                    z = z - 1;
                }
            } else if ( curr == b1) {
                y = y - 1;
                if (x < 0) {
                    x = x - 1;
                }
                if (z < 0) {
                    z = z - 1;
                }
            } else if ( curr == c1) {
                z = z - 1;
                if (x < 0) {
                    x = x - 1;
                }
                if (y < 0) {
                    y = y - 1;
                }
            } if (curr == a2) {
                x = x + 1;
                if (y < -1) {
                    y = y + 1;
                }
                if (z < -1) {
                    z = z + 1;
                }
            } else if ( curr == b2) {
                y = y + 1;
                if (x < -1) {
                    x = x + 1;
                }
                if (z < -1) {
                    z = z + 1;
                }
            } else if ( curr == c2) {
                z = z + 1;
                if (x < -1) {
                    x = x + 1;
                }
                if (y < -1) {
                    y = y + 1;
                }
            }
            if (x > 0 || y > 0 || z > 0) {
                System.out.println(br + " Invalid String at " + i + " char.");
                return;
            }
        }
        if (x != 0 || y != 0 || z != 0) {
            System.out.println(br + " Invalid String.");
            return;
        }
        System.out.println(br + " Valid.");
    }
}
