import domain.*;
import service.ClientService;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestMedicine {
    public static void main(String[] args) {
        ClientService service = new ClientService();

        Address address = new Address("Nezalegnosti", 27, 24, false, City.KIEV);

        Client client = new Client("Palko", "Andrii", "Volodimirovich",
                12, Gender.Man, LocalDate.of(1983, 1, 7), "okna-83@mail.ru");

        Ticket ticket = new Ticket(LocalDateTime.now(), Polyclinic.Hospital, 23, true, Service.Consultation);

        Doctor doctor = new Doctor("Ivanov", "Petro", "Ivanovich", "34", Gender.Man,
                "1980.02.10", Category.category_1, Profile.Dentist);
        History history = new History(doctor,"delete tooth");
        client.addHistory(history);
        ticket.setDoctor(doctor);
        doctor.setTicket(ticket);
        address.setClient(client);
        client.setAddress(address);
        service.save(client);


    }
}
