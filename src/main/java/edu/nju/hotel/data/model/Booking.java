package edu.nju.hotel.data.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by zhouxiaofan on 2017/2/4.
 */
@Entity
@Table(name = "booking")
public class Booking {
    private int id;
    private Date inTime;
    private Date outTime;
    private Integer roomNum;
    private String nameinfo;
    private String phone;
    private String email;
    private Integer price;
    private int cancled;
    private int deposit;
    private User userByUserId;
    private Hotel hotelByHotelId;
    private RoomType roomTypeByRoomTypeId;
    private Checkin checkinsById;
    private Collection<RoomAsign> roomAsignsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "inTime", nullable = false)
    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    @Basic
    @Column(name = "outTime", nullable = false)
    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    @Basic
    @Column(name = "roomNum", nullable = true)
    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    @Basic
    @Column(name = "nameinfo", nullable = false, length = 200)
    public String getNameinfo() {
        return nameinfo;
    }

    public void setNameinfo(String nameinfo) {
        this.nameinfo = nameinfo;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "price", nullable = true)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "cancled", nullable = false)
    public int getCancled() {
        return cancled;
    }

    public void setCancled(int cancled) {
        this.cancled = cancled;
    }

    @Basic
    @Column(name = "deposit", nullable = false)
    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (id != booking.id) return false;
        if (cancled != booking.cancled) return false;
        if (deposit != booking.deposit) return false;
        if (inTime != null ? !inTime.equals(booking.inTime) : booking.inTime != null) return false;
        if (outTime != null ? !outTime.equals(booking.outTime) : booking.outTime != null) return false;
        if (roomNum != null ? !roomNum.equals(booking.roomNum) : booking.roomNum != null) return false;
        if (nameinfo != null ? !nameinfo.equals(booking.nameinfo) : booking.nameinfo != null) return false;
        if (phone != null ? !phone.equals(booking.phone) : booking.phone != null) return false;
        if (email != null ? !email.equals(booking.email) : booking.email != null) return false;
        if (price != null ? !price.equals(booking.price) : booking.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (inTime != null ? inTime.hashCode() : 0);
        result = 31 * result + (outTime != null ? outTime.hashCode() : 0);
        result = 31 * result + (roomNum != null ? roomNum.hashCode() : 0);
        result = 31 * result + (nameinfo != null ? nameinfo.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + cancled;
        result = 31 * result + deposit;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "hotelId", referencedColumnName = "id", nullable = false)
    public Hotel getHotelByHotelId() {
        return hotelByHotelId;
    }

    public void setHotelByHotelId(Hotel hotelByHotelId) {
        this.hotelByHotelId = hotelByHotelId;
    }

    @ManyToOne
    @JoinColumn(name = "roomTypeId", referencedColumnName = "id", nullable = false)
    public RoomType getRoomTypeByRoomTypeId() {
        return roomTypeByRoomTypeId;
    }

    public void setRoomTypeByRoomTypeId(RoomType roomTypeByRoomTypeId) {
        this.roomTypeByRoomTypeId = roomTypeByRoomTypeId;
    }

    @OneToOne(mappedBy = "bookingByBookId")
    public Checkin getCheckinsById() {
        return checkinsById;
    }

    public void setCheckinsById(Checkin checkinsById) {
        this.checkinsById = checkinsById;
    }

    @OneToMany(mappedBy = "bookingByBookId")
    public Collection<RoomAsign> getRoomAsignsById() {
        return roomAsignsById;
    }

    public void setRoomAsignsById(Collection<RoomAsign> roomAsignsById) {
        this.roomAsignsById = roomAsignsById;
    }
}