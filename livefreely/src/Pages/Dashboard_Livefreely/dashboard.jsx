import React from 'react';

function Dashboard() {
    return (
        <div className="container mt-5">
            <h1 className="mb-4">Dashboard</h1>
            <div className="row">
                <div className="col-md-6">
                    <div className="card mb-4">
                        <div className="card-body">
                            <h5 className="card-title">Welcome to Your Dashboard</h5>
                            <p className="card-text">
                                This is the main dashboard page where you can view and manage your
                                content and activities.
                            </p>
                        </div>
                    </div>
                </div>
                <div className="col-md-6">
                    <div className="card mb-4">
                        <div className="card-body">
                            <h5 className="card-title">Recent Activity</h5>
                            <p className="card-text">
                                Here, you can see your recent activity and updates related to your
                                account.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Dashboard;
