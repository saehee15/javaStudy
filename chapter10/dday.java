import java.util.Calendar;

// date1과 date2 차이를 계산, 디데이 계산할때
class dday {
    public static void main(String[] args){
        //  요일을 1부너 시작하기에, DAY_OF_WEEK[0]은 비어둠
        final String[] DAY_OF_WEEK = { "", "월", "화", "수", "목", "금", "토", "일"};

        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();

        date1.set( 2021, 9, 8);
        System.out.println("date1은" + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일이고, ");
        System.out.println("date2은" + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일이고, ");

        // 두 날짜의 차이 -> 날짜를 초로 변환, 차이 구한 후 시간, 분, 초나 년, 월, 일로 변경
        // getTimeInMillis() 천분의 일초 단위로 변환
        long difference = 
            (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
        System.out.println("date1부터 date2까지는" + difference + "초가 지났습니다.");
        System.out.println("일(day)로 계산하면" + difference/(24 * 60 * 60) + "일입니다."); //1일 = 24 * 60 * 60
    }
        public static String toString(Calendar date) {
            return date.get(Calendar.YEAR) + "년" + (date.get(Calendar.MONTH)) + "월" 
            + date.get(Calendar.DATE) + "일";
        }

}
