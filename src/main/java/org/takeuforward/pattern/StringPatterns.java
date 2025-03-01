package org.takeuforward.pattern;

public class StringPatterns {

    public static void main(String[] args) {
        patternOne();
        patternTwo();
        patternThree();
        patternFour();
        patternFive();
        patternSix();
        patternSeven();
        patternEight();
        patternNine();
        patternTen();
        patternEleven();
        patternTwelve();
        patternThirteen();
        patternFourteen();
        patternFifteen();
        patternSixteen();
        patternSeventeen();
        patternEighteen();
        patternNineteen();
        patternTwenty();
        patternTwentyOne();
        patternTwentyTwo();
        patternTwentyTwoBetter();
        patternRevision();
    }

    public static void patternOne() {
        for (int i = 0; i < 5; i++) {
            System.out.println("*****");
        }
    }

    public static void patternTwo() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patternThree() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void patternFour() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void patternFive() {
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patternSix() {
        for (int i = 5; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void patternSeven() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = (n - i) - 1; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < (2 * (i + 1) - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patternEight() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            int star = (2 * n - 1) - (2 * i);
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patternNine() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (2 * i - 1); j++) {
                System.out.print("*");
            }
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (2 * i - 1); j++) {
                System.out.print("*");
            }
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void patternTen() {
        int n = 3;
        for (int i = 1; i <= (2 * n) - 1; i++) {
            int star = i;
            if (i > n) star = (2 * n) - i;
            for (int j = 1; j <= star; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patternEleven() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            int start = i % 2 == 0 ? 1 : 0;
            for (int j = 0; j <= i; j++) {
                System.out.print(start);
                start = 1 - start;
            }
            System.out.println();
        }
    }

    public static void patternTwelve() {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
                count++;
            }
            for (int j = 1; j < 2 * (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = count; j > 0; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void patternThirteen() {
        int n = 5;
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(count++ + " ");
            }
            System.out.println();
        }
    }

    public static void patternFourteen() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (char ch = 'A'; ch <= 'A' + i; ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void patternFifteen() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (char ch = 'A'; ch <= 'A' + (n - i - 1); ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void patternSixteen() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char) ('A' + i));
            }
            System.out.println();
        }
    }

    public static void patternSeventeen() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n - i) - 1; j++) {
                System.out.print(" ");
            }
            char ch = 'A' - 1;
            for (int j = 0; j < (2 * i) + 1; j++) {
                if (j > i) System.out.print(--ch);
                else System.out.print(++ch);
            }
            System.out.println();
        }
    }

    public static void patternEighteen() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            char ch = (char) ('A' + n - i - 1);
            for (int j = 0; j <= i; j++) {
                System.out.print(ch++);
            }
            System.out.println();
        }
    }

    public static void patternNineteen() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2 * (i + 1) - 2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2 * (i + 1) - 2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patternTwenty() {
        int n = 5;
        for (int i = 0; i < (2 * n) - 1; i++) {
            int star = i;
            if (i > n - 1) star = (2 * (n - 1)) - i;

            int space = (2 * n) - (2 * (star + 1));

            for (int j = 0; j <= star; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= star; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patternTwentyOne() {
        int n = 6;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    /**
     * O(n) -> n^3 BAD
     */
    public static void patternTwentyTwo() {
        int n = 4;
        for (int i = 0; i < (2 * n) - 1; i++) {
            for (int j = 0; j < (2 * n) - 1; j++) {
                int check = 1;
                int checkLowerLimit = n - 1;
                int checkUpperLimit = n - 1;
                while (check <= n) {
                    if ((i >= checkUpperLimit && i <= checkLowerLimit) && (j >= checkUpperLimit && j <= checkLowerLimit)) {
                        System.out.print(check);
                        break;
                    } else {
                        checkLowerLimit++;
                        checkUpperLimit--;
                    }
                    check++;
                }
            }
            System.out.println();
        }
    }

    /**
     * Computes distance from current cell to all border, then picks the minimum.
     * The minimum distance is than subtracted from n
     * O(n) -> n^2
     */
    public static void patternTwentyTwoBetter() {
        int n = 5;
        int columnLength = (2 * n) - 1;
        int rowLength = (2 * n) - 1;
        for (int i = 0; i < (2 * n) - 1; i++) {
            for (int j = 0; j < (2 * n) - 1; j++) {
                int min = Math.min(Math.min(i, j), Math.min(columnLength - j - 1, rowLength - i - 1));
                System.out.print(n - min);
            }
            System.out.println();
        }
    }

    public static void patternRevision() {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

}
