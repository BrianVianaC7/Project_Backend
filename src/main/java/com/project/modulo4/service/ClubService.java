package com.project.modulo4.service;

import com.project.modulo4.mapper.ClubMapper;
import com.project.modulo4.mapper.LeagueMapper;
import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.club.dto.CreateClubDTO;
import com.project.modulo4.models.club.dto.UpdateClubDTO;
import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.models.league.model.LeagueModel;
import com.project.modulo4.repository.ClubRepository;
import com.project.modulo4.utils.exception.ClubNotFoundException;
import com.project.modulo4.utils.exception.LeagueNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ClubService {


    ClubRepository clubRepository = new ClubRepository() {
        @Override
        public List<LeagueModel> findLeagueByClub(long clubId) {
            return null;
        }

        @Override
        public Long findMaxClubId() {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends ClubModel> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends ClubModel> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<ClubModel> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public ClubModel getOne(Long aLong) {
            return null;
        }

        @Override
        public ClubModel getById(Long aLong) {
            return null;
        }

        @Override
        public ClubModel getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends ClubModel> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends ClubModel> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public <S extends ClubModel> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public List<ClubModel> findAll() {
            return null;
        }

        @Override
        public List<ClubModel> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends ClubModel> S save(S entity) {
            return null;
        }

        @Override
        public Optional<ClubModel> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(ClubModel entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends ClubModel> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public List<ClubModel> findAll(Sort sort) {
            return null;
        }

        @Override
        public Page<ClubModel> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends ClubModel> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends ClubModel> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends ClubModel> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends ClubModel> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends ClubModel, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };

    ClubMapper clubMapper = new ClubMapper() {
        @Override
        public ClubDTO toDTO(ClubModel clubModel) {
            return null;
        }

        @Override
        public ClubModel toModel(CreateClubDTO createClubDTO) {
            return null;
        }

        @Override
        public ClubModel updateToModel(UpdateClubDTO updateClubDTO, ClubModel clubModel) {
            return null;
        }

        @Override
        public ClubModel toModel(ClubDTO clubDTO) {
            return null;
        }

        @Override
        public List<ClubDTO> toDTO(List<ClubModel> model) {
            return null;
        }
    };


    private final LeagueMapper leagueMapper =  new LeagueMapper() {
        @Override
        public LeagueDTO toDTO(LeagueModel leagueModel) {
            return null;
        }

        @Override
        public List<LeagueDTO> toDTO(List<LeagueModel> model) {
            return null;
        }

        @Override
        public LeagueModel toModel(LeagueDTO leagueDTO) {
            return null;
        }
    };


    private final LeagueService leagueService = new LeagueService();

    public List<ClubDTO> getAll() {
        List<ClubModel> clubs = clubRepository.findAll();
        return clubs.stream().map(clubMapper::toDTO).toList();
    }

    public ClubDTO getById(Long clubId) throws ClubNotFoundException {
        Optional<ClubModel> clubOptional = clubRepository.findById(clubId);
        return clubOptional.map(clubMapper::toDTO).orElse(null);
    }

    @Transactional
    public ClubDTO createClub(CreateClubDTO createClubDTO, Long leagueId) throws LeagueNotFoundException {
        LeagueDTO leagueDTO = leagueService.getById(leagueId);
        if (leagueDTO == null) {
            throw new LeagueNotFoundException(leagueId);
        }

        ClubModel clubModel = clubMapper.toModel(createClubDTO);
        clubModel.setLeague(leagueMapper.toModel(leagueDTO));
        // Obtienes el próximo ID disponible manualmente
        long nextId = clubRepository.findMaxClubId() + 1;
        clubModel.setClubId(nextId);
        clubModel = clubRepository.save(clubModel);

        return clubMapper.toDTO(clubModel);
    }


    public ClubDTO updateClub(Long clubId, UpdateClubDTO updateClubDTO) throws ClubNotFoundException {
        Optional<ClubModel> clubOptional = clubRepository.findById(clubId);
        if (clubOptional.isPresent()) {
            ClubModel existingClub = clubOptional.get();
            clubMapper.updateToModel(updateClubDTO, existingClub);
            ClubModel updatedClub = clubRepository.save(existingClub);
            return clubMapper.toDTO(updatedClub);
        } else {
             throw new ClubNotFoundException(clubId);
        }
    }

}
