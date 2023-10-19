package ru.job4j.cinema.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.dto.FilmDto;
import ru.job4j.cinema.model.Film;
import ru.job4j.cinema.repository.FilmRepository;
import ru.job4j.cinema.repository.GenreRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@ThreadSafe
public class SimpleFilmService implements FilmService {
    private final FilmRepository filmRepository;
    private final GenreRepository genreRepository;

    public SimpleFilmService(FilmRepository filmRepository, GenreRepository genreRepository) {
        this.filmRepository = filmRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public Optional<FilmDto> findById(int id) {
        var optionalFilmDto = filmRepository.findById(id);
        if (optionalFilmDto.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new FilmDto(optionalFilmDto.get().getId(),
                optionalFilmDto.get().getName(),
                optionalFilmDto.get().getDescription(),
                optionalFilmDto.get().getYear(),
                optionalFilmDto.get().getMinAge(),
                optionalFilmDto.get().getDuration(),
                genreRepository.findById(optionalFilmDto.get().getGenreId()).get().getName()));
    }

    @Override
    public Collection<FilmDto> findAll() {
        List<FilmDto> filmDtoList = new ArrayList<>();
        for (Film film : filmRepository.findAll()) {
            filmDtoList.add(new FilmDto(film.getId(), film.getName(), film.getDescription(),
                    film.getYear(), film.getMinAge(), film.getDuration(),
                    genreRepository.findById(film.getId()).get().getName()));
        }
        return filmDtoList;
    }
}
