//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        CinemaManager manager = new CinemaManager();
        InputMenu menu = new InputMenu();
        boolean run = true;

        while(run) {
            switch(menu.inputMainMenu()) {
                case 1:
                    manager.addMovie(menu);
                    break;
                case 2:
                    manager.printAllMovies();
                    break;
                case 3:
                    manager.findMovie(menu);
                    break;
                case 4:
                    manager.editMovieInfo(menu);
                    break;
                case 5:
                    manager.deleteMovie(menu);
                    break;
                case 6:
                    manager.addScreening(menu);
                    break;
                case 7:
                    manager.printAllScreenings();
                    break;
                case 8:
                    manager.findMovieScreening(menu);
                    break;
                case 9:
                    manager.deleteScreening(menu);
                    break;
                case 10:
                    manager.addCustomer(menu);
                    break;
                case 11:
                    manager.printAllCustomer();
                    break;
                case 12:
                    manager.findCustomer(menu);
                    break;
                case 13:
                    manager.reserveSeat(menu);
                    break;
                case 14:
                    manager.cancelReservation(menu);
                    break;
                case 15:
                    manager.printAllReservation();
                    break;
                case 16:
                    manager.findReservationByCustomer(menu);
                    break;
                case 17:
                    manager.printReservedInfoByScreening(menu);
                    break;
                case 18:
                    manager.totalSales();
                    break;
                case 19:
                    manager.salesByMovie();
                    break;
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                    manager.totalPaymentByCustomer();
                    break;
                case 25:
                    manager.nonReservedCustomer();
                    break;
                case 26:
                    manager.sortByMovieName();
                    break;
                case 27:
                    manager.sortByReservationRate();
                    break;
                case 28:
                    manager.test();
                    break;
                case 29:
                    System.out.println("종료");
                    run = false;
            }
        }

        }
    }
