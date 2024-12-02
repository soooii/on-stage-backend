package com.team5.on_stage.concert.service;

import com.team5.on_stage.concert.repository.ConcertDetailRepository;
import com.team5.on_stage.concert.repository.ConcertPlaceRepository;
import com.team5.on_stage.concert.repository.RelateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConcertService {
    private final ConcertInfoRequestService concertInfoRequestService;

    private final ConcertDetailRepository concertDetailRepository;
    private final ConcertPlaceRepository concertPlaceRepository;
    private final RelateRepository relateRepository;


    //저장작업(레포와 연결), 벌크인서트 사용
    //C
    public void saveConcertList() {
    }

    //R
    public void getConcertUpdatedDate(){
    }
    public void getConcertList(){
    }
    public void getConcertMap(){
    }

    //U
    public void patchConcertList(){
    }

    //D
    public void deleteConcertInfo(){
    }
}


/*
    public List<CheckOutItemResponseDto> getCheckOutItem(Long checkoutId){
        List<CheckOutItem> checkOuts = checkOutItemRepository.findByCheckOutId(checkoutId);
        return checkOuts.stream()
                .map(checkOutItem -> checkOutItem.toDto())
                .collect(Collectors.toList());
    }

    //TODO Transactional을 언제, 왜, 어떻게 써야할까요?
    @Transactional
    public CheckOutResponseDto createCheckout(Long userId, CheckOutRequestDto checkOutRequestDto) {
        CheckOut checkOut = CheckOut.builder()
                .summaryTitle(checkOutRequestDto.getSummaryTitle())
                .totalPrice(checkOutRequestDto.getTotalPrice())
                .user(userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("userId not found")))
                .address(checkOutRequestDto.getAddress().toEntity())
                .request(checkOutRequestDto.getRequest())
                .build();
        checkOutRepository.save(checkOut);
        return checkOut.toDto();
    }

    @Transactional
    public void addCheckOutItem(CheckOutItemRequestDto checkoutItemRequestDto) {
        CheckOutItem checkOutItem = CheckOutItem.builder()
                .item(itemRepository.findById(checkoutItemRequestDto.getItemId()).orElseThrow(() -> new IllegalArgumentException("itemId not found")))
                .quantity(checkoutItemRequestDto.getQuantity())
                .totalPrice(checkoutItemRequestDto.getTotalPrice())
                .checkOut(checkOutRepository.findById(checkoutItemRequestDto.getCheckOutId()).orElseThrow(() -> new IllegalArgumentException("checkoutId not found")))
                .build();
        checkOutItemRepository.save(checkOutItem);

        // 주문 완료 후 재고 감소
        Item item = itemRepository.findById(checkoutItemRequestDto.getItemId())
                .orElseThrow(() -> new IllegalArgumentException("itemId not found"));
        item.removeStock(checkoutItemRequestDto.getQuantity());
    }

    public List<CheckOutResponseDto> getCheckOuts(Long userId) {
        List<CheckOut> checkOuts = checkOutRepository.findByUserId(userId);
        return checkOuts.stream()
                .map(checkOut -> checkOut.toDto())
                .collect(Collectors.toList());
    }

    public CheckOutResponseDto updateCheckOut(Long detailId, CheckOutRequestDto checkOutRequestDto) {
        CheckOut checkOut =  checkOutRepository.findById(detailId).orElseThrow(() -> new IllegalArgumentException("checkoutId not found"));
        checkOut.updateAddress(checkOutRequestDto);
        checkOutRepository.save(checkOut);
        return  checkOut.toDto();
    }

    public CheckOutResponseDto getCheckOutDetail(Long detailId) {
        CheckOut checkOut = checkOutRepository.findById(detailId).orElseThrow(() -> new IllegalArgumentException("checkoutId not found"));
        return checkOut.toDto();
    }

    public Long deleteCheckOut(Long detailId) {
        checkOutRepository.deleteById(detailId);
        return detailId;
    }

    public CheckOutResponseDto updateDeliveryStatus(Long detailId, DeliveryStatus deliveryStatus) {
        CheckOut checkOut = checkOutRepository.findById(detailId).orElseThrow(() -> new IllegalArgumentException("checkoutId not found"));
        checkOut.updateDeliveryStatus(deliveryStatus);
        return checkOut.toDto();
    }

    // More methods for updating, deleting checkout and checkout items

    // 즉시 구매 조회
    public CheckOutEachResponseDto getCheckOutEach(Long userId) {
        CheckOutEach checkOutEach = checkOutEachRepository.findByUserId(userId);

        return new CheckOutEachResponseDto(checkOutEach);
    }

    // 즉시 구매를 위해 정보 임시 저장
    @Transactional
    public Long addCheckOutEach(Long userId, CheckOutEachRequestDto checkOutEachRequestDto) {
        checkOutEachRepository.deleteByUserId(userId); // 사용자가 뒤로 갔다가 올 경우를 대비한 DB 초기화

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        Item item = itemRepository.findById(checkOutEachRequestDto.getItemId())
                .orElseThrow(() -> new NoSuchElementException("Item not found. item id : " + checkOutEachRequestDto.getItemId()));

        CheckOutEach checkOutEach = new CheckOutEach(user, item, checkOutEachRequestDto.getQuantity());
        checkOutEachRepository.save(checkOutEach);
        return checkOutEach.getId();
    }

    // 주문완료 후 즉시 구매 삭제
    @Transactional
    public void deleteCheckOutEach(Long checkOutEacId) {
        checkOutEachRepository.deleteById(checkOutEacId);
    }

    // 어드민 주문 내역 전체 조회
    public List<CheckOutResponseDto> getAllCheckOuts() {
        List<CheckOut> checkOuts = checkOutRepository.findAll();
        return checkOuts.stream()
                .map(checkOut -> checkOut.toAdminDto())
                .collect(Collectors.toList());
    }

    public Long deleteUserCheckOut(Long detailId) {
        CheckOut checkOut = checkOutRepository.findById(detailId).orElseThrow(() -> new IllegalArgumentException("checkoutId not found"));
        checkOutRepository.delete(checkOut);
        return detailId;
    }
}



*/