import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './components/NavBar';
import ProductList from './components/ProductList';
import ProductDetails from './components/ProductDetails';
import UsersList from './components/UsersList';
import UserDetails from './components/UserDetails';
import OrdersList from './components/OrdersList';
import OrderDetails from './components/OrderDetails';

function App() {
  return (
    <Router>
      <div>
        <Navbar />
        <Routes>
          <Route path="/" element={<h1>Home Page</h1>} />
          <Route path="/products" element={<ProductList />} />
          <Route path="/products/:id" element={<ProductDetails />} />
          <Route path="/users" element={<UsersList />} />
          <Route path="/users/:id" element={<UserDetails />} />
          <Route path="/orders" element={<OrdersList />} />
          <Route path="/orders/:id" element={<OrderDetails />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
