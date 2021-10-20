import React from 'react';
import {
    FaRoute,
    FaArrowAltCircleRight,
    FaUserFriends,
    FaSuitcase,
    FaTelegramPlane,
    FaTicketAlt,
    FaWallet
} from 'react-icons/fa';
import {BiDotsHorizontalRounded} from 'react-icons/bi'

export const routes = [
    {
        id: 1,
        name: 'Ha Noi-Vinh',
        today: 2,
        icon: <BiDotsHorizontalRounded/>
    },
    {
        id: 2,
        name: 'Ha Noi-Tp. Ho Chi Minh',
        today: 2,
        icon: <BiDotsHorizontalRounded/>
    },
    {
        id: 3,
        name: 'Ha Noi-Tp. Da Nang',
        today: 2,
        icon: <BiDotsHorizontalRounded/>
    },
    {
        id: 4,
        name: 'Ha Noi-Tokyo',
        today: 2,
        icon: <BiDotsHorizontalRounded/>
    },
    {
        id: 5,
        name: 'Vinh-Da Nang',
        today: 2,
        icon: <BiDotsHorizontalRounded/>
    },
    {
        id: 6,
        name: 'Tokyo-Da Nang',
        today: 2,
        icon: <BiDotsHorizontalRounded/>
    },
    {
        id: 7,
        name: 'Tp. Ho Chi Minh-Vinh',
        today: 2,
        icon: <BiDotsHorizontalRounded/>
    },
    {
        id: 1,
        name: 'Bac Ninh-Ha Noi',
        today: 2,
        icon: <BiDotsHorizontalRounded/>
    }
];

export const links = [
    {
        id: 1,
        name: 'Route',
        icon: <FaRoute/>
    },
    {
        id: 2,
        name: 'Trip',
        icon: <FaArrowAltCircleRight/>
    },
    {
        id: 3,
        name: 'Client',
        icon: <FaUserFriends/>
    },
    {
        id: 4,
        name: 'Staff',
        icon: <FaSuitcase/>
    },
    {
        id: 5,
        name: 'Plane',
        icon: <FaTelegramPlane/>
    },
    {
        id: 6,
        name: 'Ticket',
        icon: <FaTicketAlt/>
    },
    {
        id: 7,
        name: 'Statistic',
        icon: <FaWallet/>
    }
];