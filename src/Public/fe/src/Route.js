import React, { useState } from 'react';
import { routes, links } from './data';
const Route = () => {
    const [page, setPage] = useState(false);

    return (
        <div className='container-fluid'>
            <div className='row'>
                <section className='col-2'>
                    <h1 className='logo'>LOGO</h1>
                    <ul>
                        {
                            links.map((link) => {
                                const {id, icon, name} = link;
                                return (
                                    <li key={id} className='link'>
                                        <button className={`${page ? 'btn active' : 'btn'}`} onClick={() => setPage(true)}>
                                            <div className='btn-content'>
                                                {icon} {name}
                                            </div>
                                        </button>
                                    </li>
                                )
                            })
                        }                        
                    </ul>
                </section>
                <section className='col-8 header'>
                    <h1 className='header'>Route Manager</h1>
                    
                    <div className='container main-container'>
                        <div className='row'>
                            <div className='col-8'>
                                <h2>All</h2>                                   
                            </div>
                            <div className='col-4 '>
                                <input type='text' placeholder='Search' ></input>
                            </div>
                        </div>
                        <div className='underline'></div>                        
                        <div className='row'>
                            <div className='col-6 name'>
                                <h3>Name</h3>
                            </div>
                            <div className='col-3'>
                                <h3>Today</h3>                                   
                            </div>
                            <div className='col-3'>
                                    <h3 className='more-content'>More</h3>
                            </div>
                                {
                                    routes.map((route) => {
                                        const {id, name, today, icon} = route;
                                        return(
                                            <div className='container'>
                                                <div key={id} className='row route-content'>
                                                 
                                                        <div className='col-6 name-route'><h4>{name}</h4></div>
                                                        <div className='col-3 today'><h4>{today}</h4></div>
                                                        <div className='col-3 icon-dots more-icon'>{icon}</div>
                                                    
                                                </div>
                                            </div>
                                        )
                                    })
                                }
                        
                            </div>
                            
                        
                    </div>
                </section>
                <section className='col-2'>
                    <h1>hello</h1>
                </section>
            </div>
        </div>
    )
}

export default Route;
