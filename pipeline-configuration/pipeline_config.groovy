libraries{
  bind
  deploy
  fpm
  pulp
  puppet
}

stages {
  validating {
    bind_validate_zonefiles
    puppet_validate_puppetcode
    puppet_validate_hiera
  }
  packaging {
    fpm_package_deb
    fpm_package_rpm
  }
  deploying {
    deploy_deb
    deploy_rpm
  }
  mirroring {
    pulp_upload_deb
    pulp_upload_rpm
  }
}
