class Solution {
    public String intToRoman(int num) {
        String s = new String();
        int tem = num;
        int i = 0;
        int rim = 0, rev = 0;
        while (num != 0) {
            i++;
            rim = num % 10;
            num=num/10;
            rev = rev * 10 + rim;
        }
        rim = 0;
        for (; i != 0; i--) {
            rim = rev % 10;
            rev = rev / 10;

            switch (i) {
                case 1:
                    switch (rim)
                    {
                        case 1:
                            s = s+"I";
                            break;
                        case 2:
                            s = s+"II";
                            break;
                        case 3:
                            s = s+"III";
                            break;
                        case 4:
                            s = s+"IV";
                            break;
                        case 5:
                            s = s+"V";
                            break;
                        case 6:
                            s = s+"VI";
                            break;
                        case 7:
                            s = s+"VII";
                            break;
                        case 8:
                            s = s+"VIII";
                            break;
                        case 9:
                            s = s+"IX";
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    switch (rim) {
                        case 1:
                            s = s+"X";
                            break;
                        case 2:
                            s = s+"XX";
                            break;
                        case 3:
                            s = s+"XXX";
                            break;
                        case 4:
                            s = s+"XL";
                            break;
                        case 5:
                            s = s+"L";
                            break;
                        case 6:
                            s = s+"LX";
                            break;
                        case 7:
                            s = s+"LXX";
                            break;
                        case 8:
                            s = s+"LXXX";
                            break;
                        case 9:
                            s = s+"XC";
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    switch (rim) {
                        case 1:
                            s = s+"C";
                            break;
                        case 2:
                            s = s+"CC";
                            break;
                        case 3:
                            s = s+"CCC";
                            break;
                        case 4:
                            s = s+"CD";
                            break;
                        case 5:
                            s = s+"D";
                            break;
                        case 6:
                            s = s+"DC";
                            break;
                        case 7:
                            s = s+"DCC";
                            break;
                        case 8:
                            s = s+"DCCC";
                            break;
                        case 9:
                            s = s+"CM";
                            break;
                        default:
                            break;
                    }
                    break;
                case 4:
                    switch (rim) {
                        case 1:
                            s = s+"M";
                            break;
                        case 2:
                            s = s+"MM";
                            break;
                        case 3:
                            s = s+"MMM";
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        return s;
    }
}