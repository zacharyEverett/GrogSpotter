<template>
  <div>
      <carousel-3d>
  <slide :index="0">
    <div class="box">
  <article class="media">
    <div class="media-left">
      <figure class="image is-64x64">
        <img src="https://bulma.io/images/placeholders/128x128.png" alt="Image">
      </figure>
    </div>
    <div class="media-content">
      <div class="content">
        <p>
          <strong>Lin Manuel-Miranda</strong> <small>@alexanderHamilton</small> <small>31m</small>
          <br>
          How does a brewery sound? <br>
A spot to unwind and relax, <br>
Where you can sit back, grab a brew, <br>
And let all your troubles pass. <br> <br>
We here at Brewery Finder,<br>
Are here to help you out.<br>
With our extensive database,<br>
We'll point you to the best route.<br><br>
So why not give us a try?<br>
And let us help you find<br>
The perfect brewery nearby,<br>
And raise a glass to good times!
        </p>
      </div>
      <nav class="level is-mobile">
        <div class="level-left">
          <a class="level-item" aria-label="reply">
            <span class="icon is-small">
              <i class="fas fa-reply" aria-hidden="true"></i>
            </span>
          </a>
          <a class="level-item" aria-label="retweet">
            <span class="icon is-small">
              <i class="fas fa-retweet" aria-hidden="true"></i>
            </span>
          </a>
          <a class="level-item" aria-label="like">
            <span class="icon is-small">
              <i class="fas fa-heart" aria-hidden="true"></i>
            </span>
          </a>
        </div>
      </nav>
    </div>
  </article>
</div>
  </slide>
  <slide :index="1">
    <div class="box">
  <article class="media">
    <div class="media-left">
      <figure class="image is-64x64">
        <img src="https://bulma.io/images/placeholders/128x128.png" alt="Image">
      </figure>
    </div>
    <div class="media-content">
      <div class="content">
        <p>
          <strong>Tom Anderson</strong> <small>@johnsmith</small> <small>31m</small>
          <br>
          I don't know, looks good.
        </p>
      </div>
      <nav class="level is-mobile">
        <div class="level-left">
          <a class="level-item" aria-label="reply">
            <span class="icon is-small">
              <i class="fas fa-reply" aria-hidden="true"></i>
            </span>
          </a>
          <a class="level-item" aria-label="retweet">
            <span class="icon is-small">
              <i class="fas fa-retweet" aria-hidden="true"></i>
            </span>
          </a>
          <a class="level-item" aria-label="like">
            <span class="icon is-small">
              <i class="fas fa-heart" aria-hidden="true"></i>
            </span>
          </a>
        </div>
      </nav>
    </div>
  </article>
</div>
  </slide>
</carousel-3d>
  </div>
</template>

<script>
import { Carousel3d, Slide } from 'vue-carousel-3d';

export default {
 
  components: {
    Carousel3d,
    Slide
  }
  
};
</script>

<style>

</style>