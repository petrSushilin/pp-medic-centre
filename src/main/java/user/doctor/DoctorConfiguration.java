package user.doctor;

import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import user.doctor.handlers.GetAllDoctorsHandler;
import user.doctor.handlers.GetDoctorHandler;
import user.doctor.handlers.PostDoctorHandler;

@Configuration
public class DoctorConfiguration {
    @Bean
    public DoctorDAO doctorDAO(DSLContext context) {
        return new DoctorDAO(context);
    }

    @Bean
    public DoctorService doctorService(DoctorDAO doctorDAO) {
        return new DoctorService(doctorDAO);
    }

    @Bean
    public GetAllDoctorsHandler getAllDoctorsHandler (DoctorService doctorService) {
        return new GetAllDoctorsHandler(doctorService);
    }

    @Bean
    public GetDoctorHandler getDoctorHandler (DoctorService doctorService) {
        return new GetDoctorHandler(doctorService);
    }

    @Bean
    public PostDoctorHandler postDoctorHandler (DoctorService doctorService) {
        return new PostDoctorHandler(doctorService);
    }

    @Bean
    public DoctorController doctorController (GetAllDoctorsHandler getAllDoctorsHandler, GetDoctorHandler getDoctorHandler,
                                              PostDoctorHandler postDoctorHandler) {
        return new DoctorController(getAllDoctorsHandler, getDoctorHandler, postDoctorHandler);
    }
}
