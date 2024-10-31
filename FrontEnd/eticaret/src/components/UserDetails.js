import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

const UserDetails = () => {
  const { id } = useParams();
  const [user, setUser] = useState(null);

  useEffect(() => {
    // Tek bir kullanıcıyı GET ile getir
    fetch(`http://localhost:8080/api/users/${id}`)
      .then(response => response.json())
      .then(data => setUser(data))
      .catch(error => console.error('Error:', error));
  }, [id]);

  if (!user) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <h2>User Details</h2>
      <p>Username: {user.username}</p>
      <p>Email: {user.email}</p>
      <p>Role: {user.role}</p>
    </div>
  );
};

export default UserDetails;
