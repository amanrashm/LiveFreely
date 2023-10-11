import React from 'react';
import { Link } from 'react-router-dom';
import './dashboard.css';

function Dashboard() {
    return (
        <div className="landing-page">
            <div className="container">
                <div className="row">
                    <div className="col-md-6">
                        <div className="welcome-card">
                            <h1 className="mb-4">Welcome to Your Dashboard</h1>
                            <p className="card-text">
                                This is the main dashboard page where you can view and manage your
                                content and activities.
                            </p>
                            <Link to="/dashboard" className="btn btn-primary">
                                Get Started
                            </Link>
                        </div>
                    </div>
                    <div className="col-md-6">
                        <div className="activity-card">
                            <h3 className="mb-4">Recent Activity</h3>
                            <p className="card-text">
                                Here, you can see your recent activity and updates related to your
                                account.
                            </p>
                            <Link to="/dashboard" className="btn btn-secondary">
                                View Activity
                            </Link>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Dashboard;