import com.example.persona.dto.UserPersonaRequestDTO;
import com.example.persona.model.UserPersona;
import com.example.persona.repository.UserPersonaRepository;
import com.example.persona.service.UserPersonaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserPersonaServiceTest {

    @Mock
    private UserPersonaRepository repository;

    private UserPersonaService service;

    @BeforeEach
    void setUp() {
        service = new UserPersonaService(repository);
    }

    @Test
    void findByEmail_returnsPersona() {
        UserPersona persona = UserPersona.builder()
                .uid("u1")
                .email("test@example.com")
                .name("Test")
                .role("ROLE")
                .build();
        when(repository.findByEmail("test@example.com")).thenReturn(Optional.of(persona));

        UserPersona result = service.findByEmail("test@example.com");

        assertSame(persona, result);
        verify(repository).findByEmail("test@example.com");
    }

    @Test
    void findByEmail_notFound() {
        when(repository.findByEmail("missing@example.com")).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> service.findByEmail("missing@example.com"));
        assertTrue(ex.getMessage().contains("missing@example.com"));
    }

    @Test
    void findByUID_returnsPersona() {
        UserPersona persona = UserPersona.builder()
                .uid("u1")
                .email("test@example.com")
                .name("Test")
                .role("ROLE")
                .build();
        when(repository.findByUid("u1")).thenReturn(Optional.of(persona));

        UserPersona result = service.findByUID("u1");

        assertSame(persona, result);
        verify(repository).findByUid("u1");
    }

    @Test
    void findByUID_notFound() {
        when(repository.findByUid("unknown")).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> service.findByUID("unknown"));
        assertTrue(ex.getMessage().contains("unknown"));
    }

    @Test
    void createPersona_mapsAndSaves() {
        UserPersonaRequestDTO dto = new UserPersonaRequestDTO();
        dto.setUid("u1");
        dto.setEmail("test@example.com");
        dto.setName("Test");
        dto.setRole("ROLE");
        dto.setDob(LocalDate.now());
        dto.setGender("M");
        dto.setSignupDate(LocalDateTime.now());
        dto.setLastLoginDate(LocalDateTime.now());
        dto.setPhone("1234");
        dto.setAddress1("addr1");
        dto.setAddress2("addr2");
        dto.setCity("city");
        dto.setState("state");
        dto.setCountry("country");
        dto.setZip("zip");

        UserPersona saved = UserPersona.builder()
                .uid(dto.getUid())
                .email(dto.getEmail())
                .name(dto.getName())
                .role(dto.getRole())
                .build();
        when(repository.save(any(UserPersona.class))).thenReturn(saved);

        UserPersona result = service.createPersona(dto);

        ArgumentCaptor<UserPersona> captor = ArgumentCaptor.forClass(UserPersona.class);
        verify(repository).save(captor.capture());
        UserPersona passed = captor.getValue();
        assertEquals(dto.getUid(), passed.getUid());
        assertEquals(saved, result);
    }
}
