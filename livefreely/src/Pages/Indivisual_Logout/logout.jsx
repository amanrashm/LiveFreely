import React from 'react';
import "./logout.css";
function Indivisual_Logout() {
    const handleLogout = () => {
        // Make a POST request to the logout URL
        fetch("/auth/logout", {
            method: "POST",
            headers: {
                "Authorization": "Bearer YOUR_JWT_TOKEN", // Replace with the actual JWT token
                "Content-Type": "application/json"
            }
        })
            .then(response => {
                if (response.status === 204) {
                    // Successful logout
                    console.log('Individual user logged out');
                } else {
                    // Handle logout failure
                    console.error('Logout failed');
                }
            })
            .catch(error => {
                console.error("Error:", error);
                // Handle any errors during the logout process
            });
    };

    return (
        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-6">
                    <div className="card">
                        <div className="card-header">
                            <h2 className="text-center">Individual Logout</h2>
                        </div>
                        <div className="card-body">
                            <button
                                type="button"
                                className="btn btn-primary btn-block"
                                onClick={handleLogout}
                            >
                                Logout
                            </button>
                            {/* Add your logout components and content */}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Indivisual_Logout;
