<p align="center" style="font-size:18px;color:#555;margin-top:-10px;margin-bottom:24px;"> TimeLine-Trail </p>

<div align="center">

<a href="https://github.com/xiaoniucode/timeline-trail/stargazers">
  <img src="https://img.shields.io/github/stars/xiaoniucode/timeline-trail?style=for-the-badge&logo=github" alt="GitHub Stars"/>
</a>

<a href="https://github.com/xiaoniucode/timeline-trail/forks">
  <img src="https://img.shields.io/github/forks/xiaoniucode/timeline-trail?style=for-the-badge&logo=github" alt="GitHub Forks"/>
</a>

<a href="https://github.com/xiaoniucode/timeline-trail/releases/v0.1.0">
  <img src="https://img.shields.io/badge/timeline--trail-0.1.0-blue?style=for-the-badge" alt="timeline-trail:0.1.0"/>
</a>

</div>

<div align="center">
  <a href="README.md"><strong>README</strong></a> &nbsp;|&nbsp;
  <a href="README_ZH.md"><strong>中文文档</strong></a> &nbsp;|&nbsp;
</div>

## ✨ Introduction

**Timeline Trail** is a unique personal resume visualization website. It combines a timeline with a tree-like trajectory to connect scattered life experiences into a clear growth path. Key milestones are presented as nodes, highlighting their interconnections and evolutionary logic, making them easier to understand.

<div align="center">
  <img src="docs/screenshort/index.png" alt="index" height="60%" width="60%"/>
</div>

## 🚀 Quick Start

The image has been packaged and pushed to the public [docker-hub](https://hub.docker.com/r/xiaoniucode/timeline-trail)repository. On a server with Docker installed, run the following command to deploy:

```shell
sudo mkdir -p /root/timeline-trail/uploads
docker run -d \
  --name timelinetrail \
  -p 8080:8080 \
  -v /root/timeline-trail/uploads:/root/timeline_trail/upload \
  xiaoniucode/timeline-trail:latest
```

Admin login page: `http://localhost:8080/admin/login`  
Default credentials: Username `admin`, Password `123456`

## 🎨 Screenshots

<div align="center">
  <table>
    <tr>
      <td align="center">
        <img src="docs/screenshort/index2.png" alt="Home" width="95%"><br>
        <strong>Home Page</strong>
      </td>
      <td align="center">
        <img src="docs/screenshort/login.png" alt="Login" width="95%"><br>
        <strong>Login Page</strong>
      </td>
    </tr>
    <tr>
      <td align="center">
        <img src="docs/screenshort/dashboard.png" alt="Dashboard" width="95%"><br>
        <strong>Dashboard</strong>
      </td>
      <td align="center">
        <img src="docs/screenshort/config.png" alt="Config" width="95%"><br>
        <strong>Configuration Page</strong>
      </td>
    </tr>
    <tr>
      <td align="center">
        <img src="docs/screenshort/social.png" alt="Social" width="95%"><br>
        <strong>Social Features</strong>
      </td>
      <td align="center">
        <img src="docs/screenshort/milestone.png" alt="Milestone" width="95%"><br>
        <strong>Milestone Management</strong>
      </td>
    </tr>
  </table>
</div>

## Technical Stack

| Layer      | Technology          | Purpose                  |
|------------|---------------------|--------------------------|
| **Backend**| Java 8              | Main programming language |
|            | Spring Boot 2.x     | Application framework    |
|            | JPA (Hibernate)     | Data persistence layer   |
|            | H2 Database         | Embedded database        |
|            | Freemarker          | Server-side template engine |
| **Frontend**| LayUI              | UI component library     |
|            | jQuery              | DOM manipulation & AJAX  |
|            | CSS Sprite          | Image optimization technique |
|            | jsoneditor          | JSON text editor         |

## Issue Reporting

Report issues here: [issues](https://github.com/xiaoniucode/timeline-trail/issues)

## 📈 Project Trends

<p align="center">
  <a href="https://github.com/xiaoniucode/timeline-trail/stargazers">
    <img src="https://api.star-history.com/svg?repos=xiaoniucode/timeline-trail&type=Date" alt="Star History">
  </a>
</p>

## 🙏 Acknowledgments

- Homepage design inspired by materliu
- Developed with JetBrains IDEA

## 🪧 Recommended Projects

- 🚀 [https://github.com/xiaoniucode/etp](https://github.com/xiaoniucode/etp)
