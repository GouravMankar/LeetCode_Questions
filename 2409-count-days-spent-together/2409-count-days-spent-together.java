
class Solution {
    private int toDay(String date) {
        int[] daysBeforeMonth = {
            0, 31, 59, 90, 120, 151,
            181, 212, 243, 273, 304, 334
        };

        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3));

        return daysBeforeMonth[month - 1] + day;
    }

    public int countDaysTogether(
        String arriveAlice,
        String leaveAlice,
        String arriveBob,
        String leaveBob
    ) {
        int start = Math.max(
            toDay(arriveAlice),
            toDay(arriveBob)
        );

        int end = Math.min(
            toDay(leaveAlice),
            toDay(leaveBob)
        );

        return Math.max(0, end - start + 1);
    }
}
