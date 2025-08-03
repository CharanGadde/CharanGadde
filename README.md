<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Zomato Sample UI</title>
  <link rel="stylesheet" href="zomato.css">
  <script defer src="app.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
  <section id="intro">
    <nav id="navigation">
      <div class="col1">
        <a href="#"><i class="fa fa-cutlery"></i> Restaurants</a>
      </div>
      <div class="col2">
        <a href="#">Log in</a>
        <a href="#">Sign up</a>
      </div>
    </nav>
    <header id="header">
      <img class="zomato-logo" src="https://tse3.mm.bing.net/th/id/OIP.CE0tl1IvramiApiqJjzlnwHaEK?pid=Api&P=0&h=180" alt="Zomato logo">
      <div class="tagline">Discover the best food & drinks in your city</div>
      <div class="locate-and-search">
        <div class="locate">
          <i class="fa fa-map-marker location-icon"></i>
          <input type="text" class="location-search" placeholder="Location">
          <div class="triangle-icon"></div>
        </div>
        <input type="text" class="search-all" placeholder="Search for restaurants, cuisine or a dish">
        <i class="fa fa-search search-icon"></i>
      </div>
      <div class="dropdown-panel"></div>
    </header>
  </section>
  <section id="options">
    <div class="opt-1">
      <div class="opt-footer">
        <div class="opt-title">Order Online</div>
        <div class="opt-desc">Stay home and order to your doorstep</div>
      </div>
    </div>
    <div class="opt-2">
      <div class="opt-footer">
        <div class="opt-title">Dining Out</div>
        <div class="opt-desc">View today's trending restaurants</div>
      </div>
    </div>
    <div class="opt-3">
      <div class="opt-footer">
        <div class="opt-title">Nightlife & Clubs</div>
        <div class="opt-desc">Explore the city's nightlife hotspots</div>
      </div>
    </div>
  </section>
</body>
</html>
